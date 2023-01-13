<div align="center">
  🙈
  <h1>ShyBye</h1>
</div>

**Our mission** is to help individuals overcome social anxiety and loneliness by
gamifying primarily in-person social interactions through a variety of fun
social challenges

ShyBye was initially created over the span of *four days* during the 2022
"[GDI Virtual Hackathon](https://girldevelopit.com/virtual-hackathon/): Hack for
Health!" and won the "On Our Phone Tomorrow!" award

Made with &hearts; by all [our awesome contributors](https://shybye.netlify.app/about)!
<!-- TODO: add a contributor section -->

## Under the Hood
This is the frontend source code for the ShyBye app
- [**Frontend**](https://github.com/shybyeapp/frontend-web)
[Next.js](https://nextjs.org) + [MUI](https://mui.com/core/)
- [**Backend**](https://github.com/shybyeapp/backend-web)
[Spring](https://spring.io/) + [PostgreSQL](https://www.postgresql.org/)

### Running Locally

1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop)
2. Build the images and start the composed container
```shell
# (Optional) ignore cache and rebuild images
docker compose build --no-cache

# Give the container a name of "shybyeapp"
docker compose -p shybyeapp up
```
