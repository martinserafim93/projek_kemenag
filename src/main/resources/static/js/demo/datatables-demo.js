// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
    columns: [
      { title: "No." },
      { title: "NIP" },
      { title: "Nama" },
      { title: "Pangkat & Golongan" },
      { title: "Pendidikan Terakhir" },
      { title: "Jabatan" },
      { title: "Unit Kerja" },
      { title: "Sub Unit Kerja" },
      { title: "Aksi" },
    ],
  });
});
