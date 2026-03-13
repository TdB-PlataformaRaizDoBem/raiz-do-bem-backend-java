package RaizDoBem.Model;

public class TipoBeneficiario {
    private final int idTipoBeneficiario;
    private final String tipoBeneficiario;

    public int getIdTipoBeneficiario() {
        return idTipoBeneficiario;
    }

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public TipoBeneficiario(int idTipoBeneficiario, String tipoBeneficiario) {
        this.idTipoBeneficiario = idTipoBeneficiario;
        this.tipoBeneficiario = tipoBeneficiario;
    }

    @Override
    public String toString() {
        return tipoBeneficiario;
    }
}
