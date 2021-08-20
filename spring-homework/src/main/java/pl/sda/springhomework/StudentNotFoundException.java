package pl.sda.springhomework;

class StudentNotFoundException extends RuntimeException {

    private String index;

    public StudentNotFoundException(String index) {
        super("Student with id: " + index + "not found");
    }
}
