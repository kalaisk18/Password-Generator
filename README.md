🔐 Secure Password Generator

A simple desktop password generator built using **Java Swing**. The application allows users to generate customizable passwords with uppercase letters, numbers, and special characters.

It uses Java's `SecureRandom` class for random password generation and provides a convenient option to copy the generated password directly to the clipboard.

✨ Features

- 🔑 Generate random passwords
- 🔢 Custom password length from **4 to 2048 characters**
- 🔠 Optional uppercase letters (`A-Z`)
- 🔢 Optional numbers (`0-9`)
- 🔣 Optional special characters
- 🛡️ Uses `SecureRandom` for password generation
- 📋 One-click copy to clipboard
- 🖥️ Simple Java Swing graphical user interface
- ⚡ Lightweight desktop application

🛠️ Technologies Used

- **Java**
- **Java Swing**
- **AWT**
- **SecureRandom**
- **Java Collections**


 📁 Project Structure

```text
Secure-Password-Generator-Java/
│
├── PasswordGeneratorApp.java
└── README.md
```

🚀 How to Run

 Prerequisites

Make sure Java is installed on your computer.

Check your Java version:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```#

 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/Secure-Password-Generator-Java.git
```

 2. Open the project folder

```bash
cd Secure-Password-Generator-Java
```

 3. Compile the program

```bash
javac PasswordGeneratorApp.java
```

 4. Run the application

```bash
java PasswordGeneratorApp
```

🎯 How to Use

1. Launch the application.
2. Select the desired password length.
3. Choose whether to include:
   - Uppercase letters
   - Numbers
   - Special characters
4. Click **Generate Password**.
5. The generated password will appear in the text field.
6. Click **Copy** to copy the password to your clipboard.

🔐 Password Generation

The application always includes lowercase letters.

Depending on the selected options, the character pool can contain:

```text
Lowercase:
abcdefghijklmnopqrstuvwxyz

Uppercase:
ABCDEFGHIJKLMNOPQRSTUVWXYZ

Numbers:
0123456789

Special Characters:
!@#$%^&*()-_=+[]{};:,.<>/?
```

The application first ensures that at least one character from each selected character category is included. The characters are then shuffled using `SecureRandom`.

📌 Example

For example, with:

```text
Password Length: 16
Uppercase: ✓
Numbers: ✓
Special Characters: ✓
```

The application may generate a password such as:

```text
a7@Kp2!mQ9#xT4$z
```

The generated password will be different each time.

🔒 Security Note

This project uses Java's `SecureRandom` instead of the regular `Random` class for password generation.

However, this application is intended as a **learning/demo desktop project**, not as a complete password-management solution.

Generated passwords are displayed in the application's text field and copied to the system clipboard when requested. Clipboard contents may be accessible to other applications on the system.

📚 Concepts Demonstrated

This project demonstrates several Java concepts:

- Object-Oriented Programming
- Java Swing GUI development
- Event handling with `ActionListener`
- `JFrame`, `JPanel`, `JButton`, `JCheckBox`, `JSpinner`, and `JTextField`
- Layout managers
- `SecureRandom`
- `ArrayList`
- `StringBuilder`
- Clipboard operations
- Exception handling
- Lambda expressions
- Java GUI threading with `SwingUtilities.invokeLater()`

🔮 Future Improvements

Possible improvements include:

- Password strength indicator
- Exclude ambiguous characters
- Password history
- Generate multiple passwords at once
- Dark mode
- Save generated passwords
- Clear clipboard automatically after a timeout
- Export passwords to a file
- Improved UI/UX
- Password strength estimation

👨‍💻 Author

**Kalaiyarasu S**

B.Tech Artificial Intelligence & Data Science Student

---

⭐ If you found this project useful, consider giving the repository a star!