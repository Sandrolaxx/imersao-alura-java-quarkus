package org.imersao.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.imersao.dto.StickerDto;
import org.imersao.service.StickerService;

/**
 *
 * @author SRamos
 */
@Path("")
public class StickerController {

    @Inject
    StickerService stickerService;

    @POST
    @Path("/image")
    @Consumes("application/json")
    @Produces("application/image")
    public byte[] generate(StickerDto stickerDto) throws MalformedURLException, IOException {
        return stickerService.handleCreate(stickerDto);
    }

}
