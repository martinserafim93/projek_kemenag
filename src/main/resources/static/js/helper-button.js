// edit modal
$(document).ready(function () {
    $("[class='btn btn-warning btn-icon-split mb-2']").on("click", function (e) {

        e.preventDefault();

        let linkData = $(this).attr("href");

        $.get(linkData, function (pegawai, status) {
            // console.log(pegawai);
            // console.log(status);
            $("#idPeg").val(pegawai.id);
            $("#nip").val(pegawai.nip);
            $("#nama").val(pegawai.nama);
            $("#tempatL").val(pegawai.tempatL);
            $("#pangkatGol").val(pegawai.pangkatGol);
            $("#pendidikan").val(pegawai.pendidikan);
            $("#jabatan").val(pegawai.jabatan);
            $("#unitKerja").val(pegawai.unitKerja);
            $("#subUnit").val(pegawai.subUnitKerja);

            // default value date from response
            $("#tanggal").flatpickr({
                altInput: true,
                altFormat: "j F Y",
                dateFormat: "d-m-Y",
                defaultDate: pegawai.tanggalLahir
            });

        });

        // $('#editModal').modal();
    });

    $("[class='btn btn-danger btn-icon-split mb-2']").on("click", function (e) {
        e.preventDefault();

        let link = $(this);
        console.log(link);
        let dataNIP = link.attr("nip");
        console.log(link.attr("href"));
        console.log(link.attr("nip"));

        $("#yesBtn").attr("href", link.attr("href"))
        $("#confirmText").html("Apakah data ini " + dataNIP + " ingin dihapus? \<strong\>(Data tidak bisa kembali lagi!)\<\/strong\>"); 
    })
});