**Spring Boot + Google Vertex AI (Gemini API) Integration**


**Overview**

This project integrates Google Cloud Vertex AI (Gemini API) with Spring Boot to generate AI-powered responses using REST APIs.

**Features**

Uses Google Vertex AI (Gemini API) for AI-powered text generation.

Supports OAuth 2.0 authentication via a service account.

Exposes a RESTful API to generate AI responses.
Prerequisites

**Google Cloud Setup**

Create a Google Cloud Project: Google Cloud Console

Enable Vertex AI API:Go to "APIs & Services" → "Enable APIs & Services" → Search Vertex AI API → Click "Enable".

Create a Service Account:

Go to IAM & Admin → Service Accounts.

Click "Create Service Account" → Assign "Vertex AI User" role.

Generate an access token (expires after 1 hour) using the Google Cloud SDK:

```bash
gcloud auth application-default print-access-token
```

Open `src/main/resources/application.properties` and set the following properties:

```properties
google.cloud.project-id=<your-project-id>
google.cloud.access-token=<token-above>
```

The previous step of placing a JSON key file is no longer required.

**Install Java & Maven**

Ensure you have:

Java 17+

Maven 3.8+
