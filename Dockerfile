# Use an official Node.js base image
FROM node:18-bullseye

# Install Java (default JDK) and Python3
RUN apt-get update && \
    apt-get install -y default-jdk python3 python3-pip && \
    rm -rf /var/lib/apt/lists/*

# Create app directory
WORKDIR /app

# Copy package manifests and install Node deps
COPY package*.json ./
RUN npm install

# Copy all your source (including .java, .py, .js, etc.)
COPY . .

# Compile all Java sources into JavaClasses
RUN mkdir -p JavaClasses && javac -d JavaClasses *.java

# Expose the port your Express server listens on
EXPOSE 3001

# Start your Node.js server
CMD ["node", "server.js"]
