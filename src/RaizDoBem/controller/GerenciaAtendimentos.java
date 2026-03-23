
//
//    @Override
//    public List<Atendimento> listarTodos() {
//        System.out.println("----- Listando atendimentos: -----");
//
//        for (Atendimento atendimento: atendimentos) {
//            System.out.println("-----------------------------------------");
//            System.out.println("Atendimento [" + atendimento.getIdAtendimento() + "]");
//            System.out.println("Descrição do atendimento: " + atendimento.getDescricao());
//            System.out.println("Data do atendimento: " + atendimento.getDataAtendimento());
//
//            Beneficiario b1 = atendimento.getBeneficiario();
//            Dentista d1 = atendimento.getDentista();
//            String nomeBeneficiario = "";
//            String nomeDentista = "";
//            if(b1!=null){
//                nomeBeneficiario = atendimento.getBeneficiario().getNomeCompleto();
//                System.out.println("Beneficiário que recebeu o atendimento: " + nomeBeneficiario + " - ID: [" + b1.getIdBeneficiario() + "]");
//            } else{
//                System.out.println("Beneficiário não encontrado!");
//                }
//            if(d1!=null){
//                nomeDentista = atendimento.getDentista().getNomeCompleto();
//                System.out.println("Dentista responsável pelo atendimento: " + nomeDentista + " - ID: [" + d1.getIdDentista() + "]");
//            }else{
//                System.out.println("Dentista não encontrado!");
//            }
//        }
//        return atendimentos;
//    }
//
//    @Override
//    public void receberSalvarDados() {

//        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        if (idBeneficiario==0){
//            System.out.println("Beneficiário não encontrado!!");
//        }

//        if (idDentista==0){
//            System.out.println("Dentista não encontrado!!");
//        }
//
//    }
//}
