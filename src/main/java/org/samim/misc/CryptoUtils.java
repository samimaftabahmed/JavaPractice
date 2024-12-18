package org.samim.misc;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoUtils {

    public static void main(String[] args) {
        generateSonarCmd();
    }

    private static void generateSonarCmd() {
        String encryptionKey = "mysecretpassword"; // Your encryption password

        // Encrypt the text
        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        encryptor.setPassword(encryptionKey);
        String encryptedMessage = "0iu2hspTJg8u3ucwKnYKfO/X/RxSe7znn1qF+iF0VO1Cder9rViyNXOpOQGaP8SiUOISPsQdouA=";
        // Decrypt the text
        String sonarKey = encryptor.decrypt(encryptedMessage);

        String sonarCmd = "mvn clean verify sonar:sonar " +
                " -Dsonar.projectKey=JavaPractice " +
                " -Dsonar.projectName='JavaPractice' " +
                " -Dsonar.host.url=http://127.0.0.1:9000 " +
                " -Dsonar.token=";

        String cmd = sonarCmd + sonarKey;

        System.out.println(cmd);
    }

    private void normalSyntax() {
        String encryptionKey = "mysecretpassword"; // Your encryption password
        String plainText = "something_secret";

        // Encrypt the text
        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        encryptor.setPassword(encryptionKey);
        String encryptedText = encryptor.encrypt(plainText);

        // Decrypt the text
        String sonarKey = encryptor.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + sonarKey);
    }
}
