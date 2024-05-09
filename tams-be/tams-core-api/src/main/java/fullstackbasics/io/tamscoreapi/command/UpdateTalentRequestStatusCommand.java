package fullstackbasics.io.tamscoreapi.command;


import fullstackbasics.io.tamscoreapi.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateTalentRequestStatusCommand {

    @TargetAggregateIdentifier
    private String talentRequestId;
    private RequestStatus requestStatus;
}
