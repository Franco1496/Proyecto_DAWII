package com.inmuebles24.controller;

import com.inmuebles24.dtos.ClienteDTO;
import com.inmuebles24.dtos.PropiedadDTO;
import com.inmuebles24.dtos.VentaDTO;
import com.inmuebles24.service.ClienteService;
import com.inmuebles24.service.PropiedadService;
import com.inmuebles24.service.VentaService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/reporte")
public class ReporteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PropiedadService propiedadService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/cliente")
    public ResponseEntity<byte[]> generarPdfClientes() throws DocumentException {

        List<ClienteDTO> listado = clienteService.findAll();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, baos);

        document.open();

        // Agregar título
        Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph title = new Paragraph("Listado de Clientes", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        Paragraph emptySpace = new Paragraph(" ");
        emptySpace.setSpacingAfter(3); // Establece el tamaño del espacio en blanco
        document.add(emptySpace);

        PdfPTable table = new PdfPTable(9);

        // Agregar encabezados de columna
        table.addCell("ID");
        table.addCell("Documento");
        table.addCell("Nombre");
        table.addCell("Apellido");
        table.addCell("Dirección");
        table.addCell("Id ubigeo");
        table.addCell("Telefono");
        table.addCell("Correo");
        table.addCell("Fecha de Creación");
        //table.addCell("Estado");

        for (ClienteDTO cliente : listado) {
            table.addCell(String.valueOf(cliente.getId_cliente()));
            table.addCell(cliente.getDocumento());
            table.addCell(cliente.getNom_cliente());
            table.addCell(cliente.getApe_cliente());
            table.addCell(cliente.getDir_cliente());
            table.addCell(String.valueOf(cliente.getId_ubigeo().getId_ubigeo()));
            table.addCell(cliente.getTel_cliente());
            table.addCell(cliente.getCorreo_cliente());
            table.addCell(String.valueOf(cliente.getFec_creacion()));
            //table.addCell(String.valueOf(cliente.isFlag_estado()));
        }

        document.add(table);
        document.close();

        byte[] pdfBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "clientes.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/propiedad")
    public ResponseEntity<byte[]> generarPdfPropiedades() throws DocumentException {

        List<PropiedadDTO> listado = propiedadService.findAll();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, baos);

        document.open();

        // Agregar título
        Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph title = new Paragraph("Listado de Propiedades", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        Paragraph emptySpace = new Paragraph(" ");
        emptySpace.setSpacingAfter(3); // Establece el tamaño del espacio en blanco
        document.add(emptySpace);

        PdfPTable table = new PdfPTable(11);

        // Agregar encabezados de columna
        table.addCell("ID");
        table.addCell("Dirección");
        table.addCell("Ubigeo");
        table.addCell("Tipo propiedad");
        table.addCell("Cantidad habitaciones");
        table.addCell("Cantidad baños");
        table.addCell("Area total");
        table.addCell("Unidad medida");
        table.addCell("Precio total");
        table.addCell("Fecha creación");
        table.addCell("Disponible venta");

        for (PropiedadDTO propiedad : listado) {
            table.addCell(String.valueOf(propiedad.getIdPropiedad()));
            table.addCell(propiedad.getDireccionPropiedad());
            table.addCell(propiedad.getIdUbigeo().getUbigeo());
            table.addCell(propiedad.getIdTipoPropiedad().getTipo_propiedad());
            table.addCell(String.valueOf(propiedad.getCantidadHabitaciones()));
            table.addCell(String.valueOf(propiedad.getCantidadBanhos()));
            table.addCell(String.valueOf(propiedad.getAreaTotal()));
            table.addCell(propiedad.getIdUnidadMedida().getUnidad_medida());
            table.addCell(String.valueOf(propiedad.getPrecioVenta()));
            table.addCell(String.valueOf(propiedad.getFechaCreacion()));
            table.addCell(String.valueOf(propiedad.isDisponibleVenta()));
        }

        document.add(table);
        document.close();

        byte[] pdfBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "Propiedades.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }


    @GetMapping("/venta")
    public ResponseEntity<byte[]> generarPdfVenta() throws DocumentException {

        List<VentaDTO> listado = ventaService.findAll();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, baos);

        document.open();

        // Agregar título
        Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph title = new Paragraph("Listado de Ventas", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        Paragraph emptySpace = new Paragraph(" ");
        emptySpace.setSpacingAfter(3); // Establece el tamaño del espacio en blanco
        document.add(emptySpace);

        PdfPTable table = new PdfPTable(6);

        // Agregar encabezados de columna
        table.addCell("ID");
        table.addCell("Asesor");
        table.addCell("Cliente");
        table.addCell("Monto venta");
        table.addCell("Fecha creación");
        table.addCell("Estado");

        for (VentaDTO venta : listado) {
            table.addCell(String.valueOf(venta.getId_venta()));
            table.addCell(venta.getId_propiedad_asesor().getId_asesor().getNom_asesor());
            table.addCell(String.valueOf(venta.getId_cliente().getNom_cliente()));
            table.addCell(String.valueOf(venta.getMonto_venta()));
            table.addCell(String.valueOf(venta.getFec_creacion()));
            table.addCell(String.valueOf(venta.isFlag_estado()));
        }

        document.add(table);
        document.close();

        byte[] pdfBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "Ventas.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}