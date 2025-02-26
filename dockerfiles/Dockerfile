# Make it better
FROM node:18.17
LABEL authors="ttknp"

# first set dir for working
# when you remote you'll start on /usr/src/app
WORKDIR /usr/src/app

# (.) dot it means goto WORKDIR AS /usr/src/app
# COPY package.json .
# COPY package-lock.json .
# Can reduce lines
# COPY package.json package-lock.json /usr/src/app/

# copy all to /usr/src/app
COPY . /usr/src/app

# run npm i on /usr/src/app
RUN npm install

# expose port app
EXPOSE 4200

# command run utill has interupt
# it means that it can be accessed via all the IP addresses on all interfaces on the machine, including 127.0. 0.1
CMD ["/usr/src/app/node_modules/.bin/ng", "serve", "--host", "0.0.0.0"]


# Step to run
# Build
# 1. docker build -t angualar:latest . -f dockerfiles\Dockerfile_v1
# Run
# 2. docker run --name angular_app -p 4201:4200 -d angualar:latest
