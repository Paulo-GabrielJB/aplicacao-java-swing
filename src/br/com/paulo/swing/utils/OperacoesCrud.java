package br.com.paulo.swing.utils;

public enum OperacoesCrud {
    NOVO(1),
    EDITAR(2),
    EXCLUIR(3);
    
    private final Integer operacao;
    
    private OperacoesCrud(Integer operacao){
        this.operacao = operacao;
    }

    public Integer getOperacao() {
        return operacao;
    }
    
    public OperacoesCrud valueOf(Integer operacao){
        for(var x: OperacoesCrud.values())
            if(x.getOperacao().equals(operacao))
                return x;
        throw new IllegalArgumentException("Valor informado é invalido");
    }

}
