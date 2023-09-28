package lapr.project.model.audittrail;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * The type Audit Trail.
 */
public class AuditTrail {
        private int containerID;
        private int cargoManifestID;
        private String username;
        private String typeOperation;
        private Timestamp dateTimeOperation;


    /**
     * Instantiates a new Audit trail.
     */
    public AuditTrail() {

        }


    /**
     * Instantiates a new Audit trail.
     *
     * @param containerID       the container id
     * @param cargoManifestID   the cargo manifest id
     * @param username          the username
     * @param typeOperation     the type operation
     * @param dateTimeOperation the date time operation
     */
    public AuditTrail(int containerID, int cargoManifestID, String username, String typeOperation, Timestamp dateTimeOperation) {
            this.containerID = containerID;
            this.cargoManifestID = cargoManifestID;
            this.username = username;
            this.typeOperation = typeOperation;
            this.dateTimeOperation = dateTimeOperation;

        }

    /**
     * Instantiates a new Audit trail.
     *
     * @param auditTrail the audit trail
     */
    public AuditTrail(lapr.project.model.audittrail.AuditTrail auditTrail) {
            this.containerID = auditTrail.getContainerID();
            this.cargoManifestID = auditTrail.getCargoManifestID();
            this.username = auditTrail.getUsername();
            this.typeOperation = auditTrail.getTypeOperation();
            this.dateTimeOperation = auditTrail.dateTimeOperation;
        }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainerID() {
            return containerID;
        }

    /**
     * Sets container id.
     *
     * @param containerID the container id
     */
    public void setContainerID(int containerID) {
            this.containerID = containerID;
        }

    /**
     * Gets cargo manifest id.
     *
     * @return the cargo manifest id
     */
    public int getCargoManifestID() {
            return cargoManifestID;
        }

    /**
     * Sets cargo manifest id.
     *
     * @param cargoManifestID the cargo manifest id
     */
    public void setCargoManifestID(int cargoManifestID) {
            this.cargoManifestID = cargoManifestID;
        }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
            return username;
        }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
            this.username = username;
        }

    /**
     * Gets type operation.
     *
     * @return the type operation
     */
    public String getTypeOperation () {
            return typeOperation;
        }

    /**
     * Sets type operation.
     *
     * @param typeOperation the type operation
     * @return the type operation
     */
    public String setTypeOperation(String typeOperation) {
           return this.typeOperation = typeOperation;
        }

    /**
     * Gets date time operation.
     *
     * @return the date time operation
     */
    public Timestamp getDateTimeOperation() {
            return dateTimeOperation;
        }

    /**
     * Sets date time operation.
     *
     * @param dateTimeOperation the date time operation
     */
    public void setDateTimeOperation(Timestamp dateTimeOperation) {
            this.dateTimeOperation = dateTimeOperation;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditTrail that = (AuditTrail) o;
        return containerID == that.containerID && cargoManifestID == that.cargoManifestID && username.equals(that.username) && typeOperation.equals(that.typeOperation) && dateTimeOperation.equals(that.dateTimeOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerID, cargoManifestID, username, typeOperation, dateTimeOperation);
    }

    @Override
    public String toString() {
        return "AuditTrail{" +
                "containerID:" + containerID + ", cargoManifestID:" + cargoManifestID +
                ", username:" + username + ", typeOperation:" + typeOperation  +
                ", dateTimeOperation:" + dateTimeOperation;
    }
}

