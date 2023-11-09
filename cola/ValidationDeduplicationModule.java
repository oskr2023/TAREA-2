package cola;

public class ValidationDeduplicationModule {
    public static void main(String[] args) {
        int queueCapacity = 10;
        MessageQueue messageQueue = new MessageQueue(queueCapacity);

        while (true) {
            String formData = messageQueue.receiveMessage();
            if (formData != null) {
                System.out.println("Formulario recibido: " + formData);
                validateFormData(formData);
            }
        }
    }

    public static void validateFormData(String formData) {
        System.out.println("Formulario validado: " + formData);
    }
}
