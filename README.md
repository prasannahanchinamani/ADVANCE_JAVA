# 📁 File Handling & Policy Management System — Java Project

## 🚀 Overview
This Java-based backend project showcases advanced **file handling**, **buffer operations**, and **policy management** using **SOLID design principles**. It includes modules for reading/writing JSON and CSV files, merging file content, reversing file data, and managing insurance policies with clean architecture.

## 🧩 Module Breakdown

### 🔄 Buffer & File Operations

| Class Name                   | Description                                                             |
|-----------------------------|-------------------------------------------------------------------------|
| `BufferOperations.java`     | Reads/writes using buffers and merges multiple files                    |
| `MergeMultipleFiles.java`   | Combines content from multiple files using buffered streams             |
| `ReverseFileContent.java`   | Reverses content of a file line-by-line                                 |
| `BufferedReadWriteExample.java` | Demonstrates buffered read/write with JSON/CSV                        |
| `FileReadWriteExample.java` | Reads and writes structured data to files                               |
| `UserInputToFile.java`      | Captures user input and stores it in a file                             |
| `FileOperations.java`       | General file I/O operations                                             |

### 📊 JSON & CSV Handling

| Class Name                   | Description                                                             |
|-----------------------------|-------------------------------------------------------------------------|
| `FileHandlingWithJSON.java` | Parses and writes JSON data                                             |
| `FileHandlingWithCsv.java`  | Parses and writes CSV data                                              |
| `JsonUtil.java`             | Utility class for JSON serialization/deserialization                    |
| `Employee.java`             | POJO for employee data used in file operations                          |
| `Task.java`                 | POJO for task data used in file operations                              |
| `TaskManager.java`          | Manages task creation and file persistence                              |

### 🛡️ Policy Management (SOLID Principles)

| Class Name                   | Description                                                             |
|-----------------------------|-------------------------------------------------------------------------|
| `Policy.java`               | POJO representing an insurance policy                                   |
| `PolicyManager.java`        | Core logic for managing policies                                        |
| `InsurancePolicyManager.java`| High-level policy orchestration                                        |
| `FileHandler.java`          | Interface for file operations                                           |
| `FileReaderHandler.java`    | Reads policy data from files                                            |
| `FileWriterHandler.java`    | Writes policy data to files                                             |
| `PolicyFileHandler.java`    | Combines reader/writer for policy files                                 |
| `PolicyFileReader.java`     | Reads policies using structured format                                  |
| `PolicyFileWriter.java`     | Writes policies using structured format                                 |
| `Main.java`                 | Entry point for running the policy management system                    |

## ✅ Features

- Buffered file read/write with merging and reversing
- JSON and CSV parsing for structured data
- Modular file handlers with interface-driven design
- Insurance policy creation, storage, and retrieval
- SOLID principles: Single Responsibility, Open/Closed, Interface Segregation


