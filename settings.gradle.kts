rootProject.name = "application"

include(
    "application",
    "core",

    ":storage:storage-api",
    ":storage:storage-implementation",

    ":service:service-api",
    ":service:service-implementation"
)