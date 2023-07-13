include delve.inc

SRC_URI = "git://${GO_IMPORT};protocol=https;branch=master"
SRCREV = "${AUTOREV}"

GO_IMPORT = "github.com/go-delve/delve"
