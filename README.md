# <ins>Moving Co</ins>

<!--- These are examples. See https://shields.io for others or to customize this set of shields. You might want to include dependencies, project status and licence info here --->

MovingCo. is a `Platform` meant to best suit you and your moving needs. We provide a `blog` for all the `best moving tips and strategies`.

Moving out of your home can be a very emotional and daunting task, thats why we are here to connect you with others going through the exact same experiences. Feel free to read through others posts about moving to pick up some tricks and strategies or feel free to post your own tips and tricks and moving anecdotes.

This App is a `micro-services` that has a client side (front-end) repo, and a server-side (back-end) repo.

This repo consist of only the `BACK-END`

The Front-End was created using `React and Bootstrap`and can be found here <a href="https://github.com/AnAppThatMovesYou/front-end-repo">Moving Co. - Front-End</a>

## <ins>Technologies Used</ins>

- JAVA
- SpringBoot
- Maven
- Heroku (For Deployment)

## <ins>Features and Description</ins>

- Full CRUD REST API created in `SpringBoot` which is a `Java` framework
- Spring boot dependency `Spring Web Security` that allows us to configure `Authorization` and `Authentication `
- Utilizes `JWT` Authentication
- Models : User, UserRole, UserProfile and Blogs

## <ins>API Endpoints</ins>

### Roles

- GET: /role
- Post/ GET: /role/{rolename}

### User

- POST : /login
- POST : /signup
- GET : /user/list
- GET: /user/{username}

### User-Profile

- GET: /profile/{username}
- POST: /profile/username

### Blogs

GET/POST: /blogs
GET/PUT/DELETE: blogs/{blogId}

## <ins>Installing Moving Co. Back-End</ins>

To install the `Back-End`, follow these steps:

1. Make sure you have `Java` JDK version `1.8` or Higher installed.

2. Make sure to have an and IDE that supports `Java` i.e `Eclipse` or `InteliJ`

3. In your terminal make a new directory and cd into it

```
$ mkdir MovingCo
$ cd MovingCo
```

4. Fork/clone down this Repo

```
git clone <SSH>
```

## <ins>Using Moving Co. Back-End</ins>

To use Moving Co. Back-End,

1. Run the Spring Boot application in the IDE as Application
2. Test end points in `Postman`

### Viewing and Interacting with the App

- Create a new User
- Sign in with that User
- Create a profile if prompted
- Navigate to create blog from Nav bar
- Create a blog post
- See it populate in the Discover / Home section of the app
- Click on blog to see the whole post

## <ins>Contributing to Moving Co. Back-End</ins>

<!--- If your README is long or you have some specific process or steps you want contributors to follow, consider creating a separate CONTRIBUTING.md file--->

To contribute to Moving Co. Front-End, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin <project_name>/<location>`
5. Create the pull request.

## Contributors

Thanks to the following people who have contributed to this project:

- [@sanand100](https://github.com/sanand100) 📖
- [@MeesumAshary](https://github.com/MeesumAshary)🐛
- [@JuliansRecent](https://github.com/JuliansRecent) 🐛

## Reference

- [scottydocs](https://github.com/scottydocs) (for providing this awesome Readme template)
- <a href= 'https://www.youtube.com/c/JavaGuides'> Java Guides- youtube channel for React-Spring Boot Guides</a>
- <a href= 'https://www.youtube.com/watch?v=VVn9OG9nfH0'>Amigoscode- youtube channel for spring Boot java guides</a>
