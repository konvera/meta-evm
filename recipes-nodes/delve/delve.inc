SUMMARY = "Official Go implementation of the Ethereum protocol"
DESCRIPTION = "geth is the command line interface for running a full ethereum node implemented in Go."
HOMEPAGE = "https://geth.ethereum.org"
LICENSE="CLOSED"
LIC_FILES_CHKSUM=""


export CGO_ENABLED = "0"
CGO_ENABLED = "0"
inherit go-mod

DEPENDS += "virtual/libc"

GO_INSTALL = "${GO_IMPORT}/cmd/dlv"
GO_LINKSHARED = ""
RDEPENDS:${PN}-dev += "bash"
do_compile[network] = "1"
