# Project 2: Task Management System

## Overview
Build a CLI-based task management system that allows users to create, organize, and track tasks with features like priorities, due dates, categories, and subtasks.

## Learning Objectives
This project will help you practice:
- **Advanced OOP concepts** (inheritance, polymorphism, interfaces)
- **Data structures** (LinkedList, TreeMap, custom collections)
- **Date/Time handling** (LocalDateTime, comparisons, formatting)
- **Sorting and filtering** (Comparator interface, lambda expressions)
- **File I/O** (JSON-like format, error handling)
- **Enum usage** (Priority, Status levels)
- **Recursive operations** (subtask management)

## Core Features

### 1. Task Management
- Create tasks with title, description, priority, due date, category
- Edit existing tasks
- Mark tasks as complete/incomplete
- Delete tasks
- Support for **subtasks** (tasks can have child tasks)

### 2. Organization Features
- **Categories**: Work, Personal, Shopping, etc.
- **Priorities**: LOW, MEDIUM, HIGH, URGENT
- **Status**: TODO, IN_PROGRESS, COMPLETED, OVERDUE
- **Due dates**: Track and sort by deadlines

### 3. View & Filter Options
- View all tasks
- Filter by category, priority, or status
- Sort by due date, priority, or creation date
- Show overdue tasks
- Display task hierarchy (parent → subtasks)

### 4. Advanced Features
- Search tasks by keywords
- Task statistics (completion rate, overdue count)
- Data persistence (save/load from file)
- Bulk operations (mark multiple tasks complete)

## Technical Structure

### Core Classes
```
Task.java           - Main task entity
TaskManager.java    - Core business logic
Priority.java       - Enum for task priorities
TaskStatus.java     - Enum for task states
Category.java       - Enum for task categories
MenuSystem.java     - CLI interface
Main.java          - Entry point
```

### Key Design Patterns
- **Composite Pattern**: For parent tasks with subtasks
- **Strategy Pattern**: For different sorting methods
- **Builder Pattern**: For creating complex tasks
- **Observer Pattern**: For status change notifications

## Progression Plan

### Phase 1: Basic Structure
- Create core classes (Task, enums)
- Basic CRUD operations
- Simple CLI menu

### Phase 2: Advanced Features
- Add subtask support (recursive structure)
- Implement sorting and filtering
- Date handling and overdue detection

### Phase 3: Polish & Persistence
- File I/O for data persistence
- Search functionality
- Statistics and reporting
- Error handling and validation

## Sample User Experience
```
=== Task Management System ===
1. Add Task
2. View All Tasks
3. View Tasks by Category
4. Mark Task Complete
5. View Overdue Tasks
6. Add Subtask
7. Task Statistics
8. Save Data
9. Load Data
10. Exit

Enter choice: 1

=== Add New Task ===
Title: Complete Java project
Description: Finish the task management system
Category: 
  1. WORK  2. PERSONAL  3. SHOPPING  4. HEALTH
Choice: 1
Priority:
  1. LOW  2. MEDIUM  3. HIGH  4. URGENT  
Choice: 3
Due date (yyyy-mm-dd hh:mm) or press Enter for no due date: 2025-06-15 17:00

Task created successfully!
```

## Success Metrics
By completing this project, you should be comfortable with:
- Complex object relationships and hierarchies
- Advanced Java collections and algorithms
- Date/time manipulation
- Recursive data structures
- File I/O with complex data
- Interface design and implementation

Ready to start? We'll begin with the core class design and basic structure!