SUMMARY = "Reth"
DESCRIPTION = "reth is the command line interface for running a full ethereum node implemented in rust."
LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

DEPENDS += "zlib openssl"
RDEPENDS:${PN} += "openssl"

export BINDGEN_EXTRA_CLANG_ARGS
BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${WORKDIR}/recipe-sysroot -I${WORKDIR}/recipe-sysroot/usr/include"

S = "${WORKDIR}/git"
