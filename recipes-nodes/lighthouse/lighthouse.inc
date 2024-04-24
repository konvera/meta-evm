SUMMARY = "Lighthouse"
DESCRIPTION = "geth is the command line interface for running a full ethereum node implemented in Go."
HOMEPAGE = "https://geth.ethereum.org"
LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

# DEPENDS += "cmake gcc"
DEPENDS += " openssl"


S = "${WORKDIR}/git"
