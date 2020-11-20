class TryCtrl {
    private TryModel mdl;

    TryCtrl(){
//mdl = new TryModel();
    }

    public void setTryModel(TryModel tm){
        mdl = tm;
    }

    public String convertMessage(String str){
        String res;

        res = mdl.convertMessage(str);
        return res;
    }
}