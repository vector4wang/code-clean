package 逐步改进;

public class Demo141 {
}

public class Args {
	private Map<Character, ArgumentMarshaler> marshalers;
	private Set<Character> argsFound;
	private ListIterator<String> currentArgument;

	public Args(String schema, String[] args) throws ArgsException {
		marshalers = new HashMap<Character, ArgumentMarshaler>();
		argsFound = new HashSet<Character>();
		parseSchema(schema);
		parseArgumentStrings(Arrays.asList(args));
	}

	private void parseSchema(String schema) throws ArgsException {
		for (String element : schema.split(","))
			if (element.length() > 0)
				parseSchemaElement(element.trim());
	}

	private void parseSchemaElement(String element) throws ArgsException {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		if (elementTail.length() == 0)
			marshalers.put(elementId, new BooleanArgumentMarshaler());
		else if (elementTail.equals("*"))
			marshalers.put(elementId, new StringArgumentMarshaler());
		else if (elementTail.equals("#"))
			marshalers.put(elementId, new IntegerArgumentMarshaler());
		else if (elementTail.equals("##"))
			marshalers.put(elementId, new DoubleArgumentMarshaler());
		else if (elementTail.equals("[*]"))
			marshalers.put(elementId, new StringArrayArgumentMarshaler());
		else
			throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
	}

	private void validateSchemaElementId(char elementId) throws ArgsException {
		if (!Character.isLetter(elementId))
			throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
	}

	private void parseArgumentStrings(List<String> argsList) throws ArgsException {
		for (currentArgument = argsList.listIterator(); currentArgument.hasNext(); ) {
			String argString = currentArgument.next();
			if (argString.startsWith("-")) {
				parseArgumentCharacters(argString.substring(1));
			} else {
				currentArgument.previous();
				break;
			}
		}
	}

	private void parseArgumentCharacters(String argChars) throws ArgsException {
		for (int i = 0; i < argChars.length(); i++)
			parseArgumentCharacter(argChars.charAt(i));
	}

	private void parseArgumentCharacter(char argChar) throws ArgsException {
		ArgumentMarshaler m = marshalers.get(argChar);
		if (m == null) {
			throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
		} else {
			argsFound.add(argChar);
			try {
				m.set(currentArgument);
			} catch (ArgsException e) {
				e.setErrorArgumentId(argChar);
				throw e;
			}
		}
	}

	public boolean has(char arg) {
		return argsFound.contains(arg);
	}

	public int nextArgument() {
		return currentArgument.nextIndex();
	}

	public boolean getBoolean(char arg) {
		return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public String getString(char arg) {
		return StringArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public int getInt(char arg) {
		return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public double getDouble(char arg) {
		return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
	}

	public String[] getStringArray(char arg) {
		return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
	}
}

public interface ArgumentMarshaler {
	void set(Iterator<String> currentArgument) throws ArgsException;
}


==============================

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
	private boolean booleanValue = false;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		booleanValue = true;
	}

	public static boolean getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof BooleanArgumentMarshaler)
			return ((BooleanArgumentMarshaler) am).booleanValue;
		else
			return false;
	}
}

==============================


public class StringArgumentMarshaler implements ArgumentMarshaler {
	private String stringValue = "";

	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			stringValue = currentArgument.next();
		} catch (NoSuchElementException e) {
			throw new ArgsException(MISSING_STRING);
		}
	}

	public static String getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArgumentMarshaler)
			return ((StringArgumentMarshaler) am).stringValue;
		else
			return "";
	}
}


==============================



public class IntegerArgumentMarshaler implements ArgumentMarshaler {
	private int intValue = 0;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			intValue = Integer.parseInt(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(MISSING_INTEGER);
		} catch (NumberFormatException e) {
			throw new ArgsException(INVALID_INTEGER, parameter);
		}
	}

	public static int getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof IntegerArgumentMarshaler)
			return ((IntegerArgumentMarshaler) am).intValue;
		else
			return 0;
	}
}

public class ArgsException extends Exception {
	private char errorArgumentId = '\0';
	private String errorParameter = null;
	private ErrorCode errorCode = OK;

	public ArgsException() {
	}

	public ArgsException(String message) {
		super(message);
	}

	public ArgsException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ArgsException(ErrorCode errorCode, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
	}

	public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
		this.errorArgumentId = errorArgumentId;
	}

	public char getErrorArgumentId() {
		return errorArgumentId;
	}

	public void setErrorArgumentId(char errorArgumentId) {
		this.errorArgumentId = errorArgumentId;
	}

	public String getErrorParameter() {
		return errorParameter;
	}

	public void setErrorParameter(String errorParameter) {
		this.errorParameter = errorParameter;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String errorMessage() {
		switch (errorCode) {
			case OK:
				return "TILT: Should not get here.";
			case UNEXPECTED_ARGUMENT:
				return String.format("Argument -%c unexpected.", errorArgumentId);
			case MISSING_STRING:
				return String.format("Could not find string parameter for -%c.", errorArgumentId);
			case INVALID_INTEGER:
				return String.format("Argument -%c expects an integer but was '%s'.", errorArgumentId, errorParameter);
			case MISSING_INTEGER:
				return String.format("Could not find integer parameter for -%c.", errorArgumentId);
			case INVALID_DOUBLE:
				return String.format("Argument -%c expects a double but was '%s'.", errorArgumentId, errorParameter);
			case MISSING_DOUBLE:
				return String.format("Could not find double parameter for -%c.", errorArgumentId);
			case INVALID_ARGUMENT_NAME:
				return String.format("'%c' is not a valid argument name.", errorArgumentId);
			case INVALID_ARGUMENT_FORMAT:
				return String.format("'%s' is not a valid argument format.", errorParameter);
		}
		return "";
		return String.format("'%s' is not a valid argument format.", errorParameter);
	}
return"";
}

public enum ErrorCode {
	OK, INVALID_ARGUMENT_FORMAT, UNEXPECTED_ARGUMENT, INVALID_ARGUMENT_NAME, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, MISSING_DOUBLE, INVALID_DOUBLE
}