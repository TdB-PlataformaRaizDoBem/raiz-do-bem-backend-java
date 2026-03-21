
//    @Override
//    public List<Beneficiario> listarTodos() {
//        System.out.println("----- Listando beneficiários: -----");
//
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        for(Beneficiario beneficiario : beneficiarios){
//            String dataFormatada = beneficiario.getDataNascimento().format(formato);
//
//            System.out.println("----------------------------------");
//            System.out.println("ID Beneficiário: " + beneficiario.getIdBeneficiario());
//            System.out.println("CPF do beneficiário: " + beneficiario.getCpfBeneficiario());
//            System.out.println("Nome do beneficiário: " + beneficiario.getNomeCompleto());
//            System.out.println("Data de nascimento: " + dataFormatada);
//            System.out.println("Sexo: " + beneficiario.getSexo());
//            System.out.println("Tipo de beneficiário: " + beneficiario.getTipoBeneficiario());
//
//            Endereco endereco = beneficiario.getEndereco();
//            if(endereco!=null){
//                System.out.println("\nEndereço do beneficiário: ");
//                System.out.println(endereco.getLogradouro() + ", " + endereco.getNumero());
//                System.out.println("CEP: " + endereco.getCep());
//                System.out.println(endereco.getCidade() + " - " + endereco.getEstado());
//            }
//
//        }
//        return beneficiarios;
//    }
//
//    @Override
//    public void receberSalvarDados() {

//
//        System.out.println("Digite o ID do endereço do Beneficiário.");
//        int idEndereco = sc.nextInt();
//        Endereco enderecoBusca = ge.buscarPeloId(idEndereco);
//        if (enderecoBusca==null){
//            System.out.println("Endereço não encontrado!!");
//        }
//

//        beneficiarios.add(beneficiario);

