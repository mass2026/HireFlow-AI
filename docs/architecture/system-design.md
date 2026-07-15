                                +-----------+
                                |   Roles   |
                                +-----------+
                                      |
                                      |
                                      ▼
                                +-----------+
                                |   Users   |
                                +-----------+
                                   /     \
                                  /       \
                                 ▼         ▼
                       +-------------+   +-------------+
                       | Candidates  |   | Recruiters  |
                       +-------------+   +-------------+
                              |                 |
                              |                 |
                              |           +------------+
                              |           | Companies  |
                              |           +------------+
                              |                 |
                              |                 |
                              +-----------------+
                                        |
                                        ▼
                                   +---------+
                                   |  Jobs   |
                                   +---------+
                                   /    \
                                  /      \
                                 ▼        ▼
                        +---------------+  +---------------+
                        | Applications  |  | Saved Jobs    |
                        +---------------+  +---------------+
                                 |
                                 ▼
                          +--------------+
                          | Interviews   |
                          +--------------+

Candidates
     |
     ▼
+-----------+
| Resumes   |
+-----------+

Applications
     |
     ▼
+---------------------------+
| Application Status History |
+---------------------------+

# HireFlow-AI System Design

## Entity Relationship Diagram

```mermaid
erDiagram

    ROLE ||--o{ USER : has

    USER ||--|| CANDIDATE : becomes
    USER ||--|| RECRUITER : becomes

    COMPANY ||--o{ RECRUITER : employs
    COMPANY ||--o{ JOB : posts

    RECRUITER ||--o{ JOB : creates

    CANDIDATE ||--o{ APPLICATION : submits
    JOB ||--o{ APPLICATION : receives

    CANDIDATE ||--o{ SAVED_JOB : saves
    JOB ||--o{ SAVED_JOB : bookmarked

    APPLICATION ||--o{ INTERVIEW : schedules

    APPLICATION ||--o{ APPLICATION_STATUS_HISTORY : tracks

    CANDIDATE ||--|| RESUME : owns
```


## Architecture Decisions

### ADR-001
Use Feature-Based Package Structure

Reason:
Improves scalability and keeps related classes together.

---

### ADR-002
Use BaseEntity

Reason:
Avoid duplicate fields like id, createdAt and updatedAt across entities.
Supports clean inheritance and easier maintenance.

---

### ADR-003
Use PostgreSQL

Reason:
Enterprise-grade relational database with strong support for modern Spring Boot applications.
