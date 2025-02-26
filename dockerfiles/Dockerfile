# first tell base image to docker file (runtime that you work)
FROM node:18.17
LABEL authors="ttknp"

# default should set like below
WORKDIR /usr/src/app

# copy all to /usr/src/app
COPY . /usr/src/app

# run npm i on /usr/src/app
RUN npm install


# set port inside container
EXPOSE 3000

# Now I have to do is to tell Docker what command I want to run when our image is run inside of a container.
CMD [ "npm", "start" ]


# Step to run
# Build
# 1. docker build -t node:latest . -f dockerfiles\Dockerfile
# Run
# 2. docker run --name node_app -p 3001:3000 -d node:latest
