1. Quel est le but de la@EntityAnnotation ? Quel est son lien avec les tables de base de données ?

@Entity:

-Marque une classe comme entité persistante liée à une table en base de données.

-Par défaut, le nom de la table = nom de la classe (modifiable via @Table).

2. Expliquez ce qui se passe lorsque Spring Data JPA rencontre une méthode commefindByMajor(String major)dans une interface de référentiel.

findByMajor(String major):

-Spring Data JPA génère automatiquement la requête JPQL (SELECT ... WHERE major = ?) en analysant le nom de la méthode.

-Évite d'écrire des requêtes manuelles pour les opérations simples.

3. Comment Spring Boot sait-il comment se connecter à votre base de données PostgreSQL ?

-Spring Boot utilise les propriétés dans application.properties :

spring.datasource.url=jdbc:postgresql://localhost:5432/ma_bd
spring.datasource.username=user
spring.datasource.password=pass

-Auto-configuration basée sur la dépendance PostgreSQL détectée.

4. Quelle est la différence entrespring.jpa.hibernate.ddl-auto=updateetspring.jpa.hibernate.ddl-auto=create?

ddl-auto=update vs create:

-update : Met à jour le schéma sans supprimer les données existantes.
-create : Recrée le schéma à chaque démarrage et efface les données.
-Autres options : none (désactivé), validate (vérification), create-drop (supprime en fermant).