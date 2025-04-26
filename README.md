# Gestion des Étudiants - Projet Spring Boot

## Présentation du projet
Application RESTful de gestion des étudiants utilisant Spring Boot, PostgreSQL, Spring Data JPA, et Lombok.

## Technologies utilisées
- Java 17+
- Spring Boot 3.1.x
- Maven
- Spring Web
- Spring Data JPA
- Lombok
- PostgreSQL

## Architecture du projet

- `model` : Contient les entités JPA `Student` et `Course`
- `repository` : Contient les interfaces JPA `StudentRepository` et `CourseRepository`
- `service` : Contient les interfaces et implémentations de la logique métier `StudentService`, `StudentServiceImpl`, `CourseService`, `CourseServiceImpl`
- `controller` : Expose les API REST `StudentController` et `CourseController`
- `resources` : Configuration de la base de données dans `application.properties`

## Configuration de la base de données

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Entités principales

### Student

- Annotations :
  - `@Entity`
  - `@Table(name = "students")`
  - `@Id`, `@GeneratedValue`
  - Validation :
    - Email valide : `@Email`
    - Age entre 18 et 100 ans : `@Min(18)`, `@Max(100)`
- Relation :
  - `@ManyToMany` avec `Course`
  - Gestion de la table de jointure via `@JoinTable`

### Course

- Annotations :
  - `@Entity`
  - `@Table(name = "courses")`
  - `@Id`, `@GeneratedValue`
- Champs : id, name, code, credits
- Relation :
  - `@ManyToMany(mappedBy = "courses")`

## Principales fonctionnalités

### Opérations CRUD sur les étudiants
- Créer, lire, mettre à jour, supprimer un étudiant
- Valider automatiquement les données à l'aide de Bean Validation

### Gestion des cours
- Ajouter de nouveaux cours
- Associer/désassocier des étudiants à des cours

### Requêtes spécialisées
- Recherche d'étudiants par major
- Recherche d'étudiants par tranche d'âge

### Pagination et tri
- Utilisation de `Pageable` dans les endpoints REST pour retourner des étudiants paginés et triés

## Points techniques importants

- Injection des dépendances via constructeur (`@RequiredArgsConstructor` avec Lombok)
- Gestion des erreurs propre via des réponses HTTP appropriées
- SQL visible dans les logs pour faciliter l'apprentissage

## Exemples d'appels API (via cURL)

- Récupérer tous les étudiants :
```bash
curl -X GET http://localhost:8080/api/students
```

- Créer un nouvel étudiant :
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"David","lastName":"Miller","email":"david.m@example.com","age":24,"major":"Psychology"}'
```

- Inscrire un étudiant à un cours :
```bash
curl -X POST http://localhost:8080/api/students/1/courses/2
```

- Obtenir les cours d'un étudiant :
```bash
curl -X GET http://localhost:8080/api/students/1/courses
```

## Questions de consolidation

- Quel est le rôle de l'annotation `@Entity` ?
- Comment Spring Data JPA construit automatiquement une requête pour `findByMajor` ?
- Différence entre `ddl-auto=update` et `ddl-auto=create` ?

## Évolution future
- Ajout de tests unitaires avec JUnit et Mockito
- Ajout de la documentation automatique avec Swagger OpenAPI
- Sécurisation des APIs avec Spring Security

---

Un projet qui pose des bases solides pour tout futur système de gestion ! 🚀

