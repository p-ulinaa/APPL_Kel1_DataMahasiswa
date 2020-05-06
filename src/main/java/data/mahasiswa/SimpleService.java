package data.mahasiswa;

public interface SimpleService {
	
	public void createMahasiswa(String nim,String nama,int semester, String jurusan, String alamat);
	public void getMahasiswa();
}
