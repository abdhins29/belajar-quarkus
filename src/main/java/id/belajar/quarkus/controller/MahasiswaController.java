package id.belajar.quarkus.controller;

import id.belajar.quarkus.dto.MahasiswaDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/")
public class MahasiswaController {

////v1 - without produces/consumes
//    @Path("all")
//    @GET
//    public Response getAllMahasiswa(){
//        List<MahasiswaDTO> mahasiswa = List.of(new MahasiswaDTO("abdhi", "Padang", "abdhins29@gmail.com"));
//        return Response.ok(mahasiswa).build();
//    }

    private Map<String, MahasiswaDTO> mahasiswa = new HashMap<>();

    @Path("mahasiswa/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMahasiswa(){
        return Response.ok(mahasiswa.values()).build();
    }

    @Path("mahasiswa/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMahasiswa(MahasiswaDTO mahasiswaDTO){
        mahasiswa.put(mahasiswaDTO.getName(), mahasiswaDTO);
        return Response.ok("Berhasil Menambahkan Data Mahasiswa", MediaType.TEXT_PLAIN_TYPE).build();
    }

    @Path("mahasiswa/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMahasiswaByName(String name){
        MahasiswaDTO mahasiswaDTO = mahasiswa.get(name);
        if(Objects.isNull(mahasiswaDTO)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mahasiswaDTO).build();
    }
}
