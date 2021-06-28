package ingjulianvega.ximic.msscasuvisitbff.web.controller;

import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import ingjulianvega.ximic.msscasuvisitbff.web.model.response.DetailVisitByIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitBffI {

    @Operation(summary = "Endpoint to get the list of visits given a patient id", description = "Returns a list of visits", tags = {"summary"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitListBffResponse.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "summary-by-patient/{patient-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitListBffResponse> getSummaryByPatientId(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("patient-id") UUID patientId);

    @Operation(summary = "Endpoint to get the list of visits given a date", description = "Returns a list of visits", tags = {"summary"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitListBffResponse.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "summary-by-date/{date}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitListBffResponse> getSummaryByDate(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("date") OffsetDateTime date);

    @Operation(summary = "Endpoint to get the list of visits given a disease id", description = "Returns a list of visits", tags = {"summary"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = VisitListBffResponse.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "summary-by-disease/{disease-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<VisitListBffResponse> getSummaryByDisease(@Parameter(in = ParameterIn.PATH, description = "The patient id", required = true, schema = @Schema()) @NotNull @PathVariable("disease") UUID diseaseId);

    @Operation(summary = "Endpoint to get the information of a visit given the id", description = "Returns a visit", tags = {"detail"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = DetailVisitByIdResponse.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "detail/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<DetailVisitByIdResponse> getDetailById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);
    
    @Operation(summary = "Endpoint to update the information of a visit given the id", description = "Updates a visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "visit's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Visit visit);


    @Operation(summary = "Endpoint to delete a visit", description = "Deletes a visit", tags = {"visit"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
