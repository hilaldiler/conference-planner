## Conference Planner

This application is used to schedule sessions and presentations of a conference. Receives conference presentations, creates sessions, and schedules presentations into sessions.

* Presentations will be made in the morning and afternoon of the conference.
* More than one presentation can be made at the same time, both in the morning and in the afternoon.
* Morning presentations start at 9:00 and end at 12:00.
* There will be lunch at 12:00.
* Afternoon presentations start at 13:00 and continue until networking events. If there is no communication event, it ends at 17:00.
* Communication activities are held if time permits after presentations. It cannot start before 16:00 and ends at 17:00 at the latest.
* Presentation times are in minutes or "lightning" (5 minutes. See: https://en.wikipedia.org/wiki/Lightning_talk).
* There is no break between presentations.


## 🛠️ Installation Steps

To start the application, go to the Conference Planner link and clone the project to your computer.

```bash
git clone https://github.com/hilaldiler/conference-planner.git
```
Proje bağımlılıklarını yüklemek için aşağıdaki komutu çalıştırın:
```bash
mvn install
```

Run the following command to install project dependencies:
```bash
mvn spring-boot:run
```

Once the application is launched, you can send presentations and retrieve the conference plan by making an HTTP request.

An example POST request:

## Sample Request
```JSON
[
    {
        "subject": "Architecting Your Codebase",
        "duration": "60min"
    },
    {
        "subject": "Overdoing it in Python",
        "duration": "45min"
    },
    {
        "subject": "Flavors of Concurrency in Java",
        "duration": "30min"
    },
    {
        "subject": "Ruby Errors from Mismatched Gem Versions",
        "duration": "45min"
    },
    {
        "subject": "JUnit 5 - Shaping the Future of Testing on the JVM",
        "duration": "45min"
    },
    {
        "subject": "Cloud Native Java",
        "duration": "lightning"
    },
    {
        "subject": "Communicating Over Distance",
        "duration": "60min"
    },
    {
        "subject": "AWS Technical Essentials",
        "duration": "45min"
    },
    {
        "subject": "Continuous Delivery",
        "duration": "30min"
    },
    {
        "subject": "Monitoring Reactive Applications",
        "duration": "30min"
    },
    {
        "subject": "Pair Programming vs Noise",
        "duration": "45min"
    },
    {
        "subject": "Rails Magic",
        "duration": "60min"
    },
    {
        "subject": "Microservices \"Just Right\"",
        "duration": "60min"
    },
    {
        "subject": "Clojure Ate Scala (on my project)",
        "duration": "45min"
    },
    {
        "subject": "Perfect Scalability",
        "duration": "30min"
    },
    {
        "subject": "Apache Spark",
        "duration": "30min"
    },
    {
        "subject": "Async Testing on JVM",
        "duration": "60min"
    },
    {
        "subject": "A World Without HackerNews",
        "duration": "30min"
    },
    {
        "subject": "User Interface CSS in Apps",
        "duration": "30min"
    }
]
```



## Sample Response

```JSON
[
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "09:00AM",
            "endTime": "10:00AM",
            "presentation": {
                "subject": "Architecting Your Codebase",
                "duration": "60min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "10:00AM",
            "endTime": "10:45AM",
            "presentation": {
                "subject": "Overdoing it in Python",
                "duration": "45min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "10:45AM",
            "endTime": "11:15AM",
            "presentation": {
                "subject": "Flavors of Concurrency in Java",
                "duration": "30min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "11:15AM",
            "endTime": "12:00PM",
            "presentation": {
                "subject": "Ruby Errors from Mismatched Gem Versions",
                "duration": "45min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "12:00PM",
            "endTime": "01:00PM",
            "presentation": {
                "subject": "Lunch",
                "duration": ""
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "01:00PM",
            "endTime": "01:45PM",
            "presentation": {
                "subject": "JUnit 5 - Shaping the Future of Testing on the JVM",
                "duration": "45min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "01:45PM",
            "endTime": "01:50PM",
            "presentation": {
                "subject": "Cloud Native Java",
                "duration": "lightning"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "01:50PM",
            "endTime": "02:50PM",
            "presentation": {
                "subject": "Communicating Over Distance",
                "duration": "60min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "02:50PM",
            "endTime": "03:35PM",
            "presentation": {
                "subject": "AWS Technical Essentials",
                "duration": "45min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "03:35PM",
            "endTime": "04:05PM",
            "presentation": {
                "subject": "Continuous Delivery",
                "duration": "30min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "04:05PM",
            "endTime": "04:35PM",
            "presentation": {
                "subject": "Monitoring Reactive Applications",
                "duration": "30min"
            }
        }
    },
    {
        "track": 1,
        "conferenceSession": {
            "startTime": "04:35PM",
            "endTime": "05:00PM",
            "presentation": {
                "subject": "Network Event",
                "duration": ""
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "09:00AM",
            "endTime": "09:45AM",
            "presentation": {
                "subject": "Pair Programming vs Noise",
                "duration": "45min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "09:45AM",
            "endTime": "10:45AM",
            "presentation": {
                "subject": "Rails Magic",
                "duration": "60min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "10:45AM",
            "endTime": "11:45AM",
            "presentation": {
                "subject": "Microservices \"Just Right\"",
                "duration": "60min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "12:00PM",
            "endTime": "01:00PM",
            "presentation": {
                "subject": "Lunch",
                "duration": ""
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "01:00PM",
            "endTime": "01:45PM",
            "presentation": {
                "subject": "Clojure Ate Scala (on my project)",
                "duration": "45min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "01:45PM",
            "endTime": "02:15PM",
            "presentation": {
                "subject": "Perfect Scalability",
                "duration": "30min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "02:15PM",
            "endTime": "02:45PM",
            "presentation": {
                "subject": "Apache Spark",
                "duration": "30min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "02:45PM",
            "endTime": "03:45PM",
            "presentation": {
                "subject": "Async Testing on JVM",
                "duration": "60min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "03:45PM",
            "endTime": "04:15PM",
            "presentation": {
                "subject": "A World Without HackerNews",
                "duration": "30min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "04:15PM",
            "endTime": "04:45PM",
            "presentation": {
                "subject": "User Interface CSS in Apps",
                "duration": "30min"
            }
        }
    },
    {
        "track": 2,
        "conferenceSession": {
            "startTime": "04:45PM",
            "endTime": "05:00PM",
            "presentation": {
                "subject": "Network Event",
                "duration": ""
            }
        }
    }
]
```
