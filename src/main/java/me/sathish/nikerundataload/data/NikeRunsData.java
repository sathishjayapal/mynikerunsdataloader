package me.sathish.nikerundataload.data;

//@javax.persistence.Entity
class NikeRunsData {

    //    @javax.persistence.Id
//    @javax.persistence.GeneratedValue
    private Long id;
    private String name;

    public NikeRunsData() {
    }

    public NikeRunsData(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NikeRunsData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
