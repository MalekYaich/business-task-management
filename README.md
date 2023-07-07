# business-task-management

This application serves as a task management system for assigning tasks to employees. Each task is identified by a unique identifier and includes a description, as well as the identifier of the employee responsible for it. Employee details consist of an identifier, first name, last name, home address, account number, rank, and hierarchical superior. The management system follows a CRUD (Create, Read, Update, Delete) approach for each entity mentioned above and employs java RMI.

To achieve this, I have developed the following components:
- An initial server that exposes RMI objects to handle the aforementioned entities.
- A Java client that can invoke and utilize the RMI objects residing in the first server.
