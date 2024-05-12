
public
     enum Operations {

    CREATE_FILE("create"),
    EDIT_TASK("edit"),
    READ_FIlE("read"),
    CHECKING_MODULE("checking module"),
    EDITING_MODULE("editing module"),
    KILL_PROGRAM("exit"),
    STOP("stop");

    private String value;

     Operations(String value) {
        this.value = value;
    }

    public String getText(){
        return value;
    }

    public static Operations fromString(String userInputsTheAction){
        for (Operations operation : Operations.values()) {
            if (operation.value.equalsIgnoreCase(userInputsTheAction))
                return operation;
        }
        return null;
    }
}
