/*представление информации о вакансии.*/

public class Unemployed {
    String profession;
    String education;
    String lastJob;
    String reasonForDismissal;
    String maritalStatus;
    String livingConditions;
    String contactInfo;
    String jobRequirements;

    // Конструктор
    public Unemployed(String profession, String education, String lastJob, String reasonForDismissal,
                      String maritalStatus, String livingConditions, String contactInfo,
                      String jobRequirements) {
        this.profession = profession;
        this.education = education;
        this.lastJob = lastJob;
        this.reasonForDismissal = reasonForDismissal;
        this.maritalStatus = maritalStatus;
        this.livingConditions = livingConditions;
        this.contactInfo = contactInfo;
        this.jobRequirements = jobRequirements;
    }

    public static Unemployed fromString(String str) {
        String[] data = str.split("\\\\|");
        return new Unemployed(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
    }

    @Override
    public String toString() {
        return String.join(" ", profession, education, lastJob, reasonForDismissal,
                maritalStatus, livingConditions, contactInfo, jobRequirements);
    }
}
