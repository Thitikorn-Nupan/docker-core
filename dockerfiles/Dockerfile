# if i used 3.11 i'll got error
# reduce code
FROM python:3

LABEL authors="ttknp"

WORKDIR /app

# copy all on python-on-docker-app/** to /app
COPY .. ./

# then install requirements.txt on /app
RUN pip install --no-cache-dir -r requirements.txt

# cmd to run
# unable to start container process: exec: "py"
# fix buy use "python"
CMD ["python", "-m","controller.book_control"]

# Step to run
# ** -t <tag name : version> and -f <path to Dockerfile_v.1>
# **  --build-arg <Key>=<Value>
# 1. docker build -t python:latest . -f dockerfiles\Dockerfile_v1
# ** -p 8080:80 maps port 8080 on the host machine to port 80 inside the container.
# ** -d run on background , --name=<container name> , -p <port remote to container>:<port app on container>
# ** these are run image and run mysql ? for sure! ** for the fist time
# 2. docker run --name python_app -p 8081:8080 -d python:latest
# way to access container
# 3. docker exec -it <container id> sh
# ** now you can use command as linux note this case mysql is on /var/lib/mysql/
# 3.1 exit ** for leaving container