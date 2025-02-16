**Spring Boot + Google Vertex AI (Gemini API) Integration**


**Overview**

This project integrates Google Cloud Vertex AI (Gemini API) with Spring Boot to generate AI-powered responses using REST APIs.

**Features**

Uses Google Vertex AI (Gemini API) for AI-powered text generation.

Supports OAuth 2.0 authentication via a service account.

Exposes a RESTful API to generate AI responses.
Prerequisites

**Google Cloud Setup**

Create a Google Cloud Project:Google Cloud Console

Enable Vertex AI API:Go to "APIs & Services" → "Enable APIs & Services" → Search Vertex AI API → Click "Enable".

Create a Service Account & Download Key:

Go to IAM & Admin → Service Accounts.

Click "Create Service Account" → Assign "Vertex AI User" role.

Go to "Keys" → Click "Add Key" → "Create New JSON Key".

Download the JSON file and move it to src/main/resources/gemini-key.json.
or
Google Cloud SDK
gcloud auth application-default print-access-token

**Install Java & Maven**

Ensure you have:

Java 17+

Maven 3.8+
