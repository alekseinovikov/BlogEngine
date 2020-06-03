rootProject.name = "application"

include(
    "application",
    "core",

    ":storage:api",
    ":storage:implementation",

    ":service:api",
    ":service:implementation"
)