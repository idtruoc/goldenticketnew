package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.TicketDto;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.service.ticket.ITicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Controller", description = "Thao tác với Ticket")
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    @Operation(
        summary = "Lấy danh sách vé xem phim",
        description = "- Lấy ra danh sách vé xem phim của user đó"
    )
    @GetMapping
    public ResponseEntity<ResponseBase<List<TicketDto>>> getTicketsByUserId(@RequestParam Long userId){
        return ResponseEntity.ok(new ResponseBase<>(ticketService.getTicketsByUserId(userId)));
    }
}
