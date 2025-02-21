FROM alpine:latest

# we call hardcoding 
# if you set ENV name Your result will be hell <name>
ENV name John 

COPY greetings.sh .

RUN chmod +x /greetings.sh

CMD ./greetings.sh

# Step to run
# 1. docker build -t greetingshell:v1 .
# 2. docker run greetingshell:v1
# Result will be hello John
