public
    enum CheckingOperations {

    NUMBER_OF_RECEIVED_SOLUTIONS("amount of solutions"),
    ACCESS_TASKS("access"),
    NUMBER_OF_TASKS_BY_STUDENT_NAME("tasks by name"),
    SEQUENTIAL_TASKS("sequential"),
    KILL_PROGRAM("exit"),
    STOP("stop");


    private String value;

    CheckingOperations(String value) {
        this.value = value;
    }
    public String getText(){
        return value;
    }

    public static CheckingOperations fromString(String userInputsTheAction){
        for (CheckingOperations operation : CheckingOperations.values()) {
            //equalsIgnoreCase to don`t care about lower upperCase
            if (operation.value.equalsIgnoreCase(userInputsTheAction))
                return operation;
        }
        return null;
    }
}
