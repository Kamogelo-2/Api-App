# Api-App

# Expense Tracker App

A comprehensive expense tracking application with offline support, multi-language capabilities, and advanced reporting features.

## Features

### Core Features
- **User Authentication**: Secure registration and login with encrypted passwords
- **Single Sign-On (SSO)**: Google SSO integration for quick access
- **Expense Management**: Add, edit, and delete expenses with category assignment
- **Category Management**: Create and manage custom expense categories with min/max spending goals
- **Advanced Reporting**: Visual graphs and charts showing spending patterns
- **Multi-language Support**: English, Afrikaans, and isiZulu
- **Offline Mode**: Full offline functionality with automatic sync when reconnected
- **Push Notifications**: Real-time budget alerts and daily reminders
- **Settings Management**: Customize language, notifications, and sync preferences

### Technical Features
- **Offline-First Architecture**: IndexedDB storage via Dexie.js
- **REST API Integration**: Sync with backend server
- **Sync Queue**: Automatic synchronization of offline actions
- **Real-time Updates**: Push notification system for alerts
- **Responsive Design**: Mobile-first, black and white themed interface

## Features Breakdown

### Authentication
- Secure password encryption using Base64 (demo - use bcrypt in production)
- Session management via localStorage
- SSO integration with Google

### Offline Sync
- Automatic detection of online/offline status
- Queue system for offline actions
- Periodic sync every 5 minutes when online
- Manual sync option in settings

### Notifications
- Budget alerts when spending exceeds limits
- Daily reminder notifications
- Achievement notifications
- Browser permission-based system

### Multi-language
- English (default)
- Afrikaans
- isiZulu
- Language persistence across sessions

### Reports & Analytics
- Spending by category (bar chart)
- Budget performance over time (line chart)
- Expense distribution (doughnut chart)
- Customizable date ranges
