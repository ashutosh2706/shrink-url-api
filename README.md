# Shrink Url API

**RESTful API to shorten long URLs**

<br>


## 🚀 Endpoints:

- Shrink the url 
  
  ``` 
  POST /shrink
  ```
  ```
  Content-Type: application/json

  {
      "url": "https://github.com/ashutosh2706/shrink-url-api" 
  }
  ```

- Get the original url
  
  ``` 
  GET /{uid}
  ```
  ```
  Response:

  {
      "originalUrl": "https://github.com/ashutosh2706/shrink-url-api",
      "shortUrl": "a0ac3bee",
      "expDate": "2023-05-13 23:38:23.829588"
  }
  ```


<br>

## 🛠️ Built with :
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"/> <img src="https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white"/>

<br>

## 📝Contribution:

Any contributions you make are greatly appreciated. If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue if found any bug. Don't forget to give the project a star! Thanks again!😊

<br>