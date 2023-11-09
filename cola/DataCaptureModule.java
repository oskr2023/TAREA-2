package cola;

import java.util.Random;

public class DataCaptureModule {
    public static void main(String[] args) {
        int queueCapacity = 10; 
        MessageQueue messageQueue = new MessageQueue(queueCapacity);

        for (int i = 0; i < 5; i++) {
            String formData = generateRandomFormData();
            messageQueue.sendMessage(formData);
            System.out.println("Formulario enviado: " + formData);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generateRandomFormData() {
        Random random = new Random();
        int id = random.nextInt(1000);
        String name = "Persona" + id;
        int age = random.nextInt(100);
        String city = getRandomCity();

        return String.format("{\"id\": %d, \"name\": \"%s\", \"age\": %d, \"city\": \"%s\"}", id, name, age, city);
    }

    public static String getRandomCity() {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Miami", "San Francisco", "Seattle"};
        Random random = new Random();
        int index = random.nextInt(cities.length);
        return cities[index];
    }
}
