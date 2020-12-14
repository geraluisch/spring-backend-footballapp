package com.escalab.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escalab.dto.FiltroPartidoDTO;
import com.escalab.dto.PartidoResultadoDTO;
import com.escalab.dto.PartidoResumenDTO;
import com.escalab.model.Partido;
import com.escalab.repo.IPartidoRepo;
import com.escalab.repo.IResultadoRepo;
import com.escalab.service.IPartidoService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PartidoServiceImpl implements IPartidoService {
	
	@Autowired
	private IPartidoRepo repo;
	
	@Autowired
	private IResultadoRepo reRepo;

	@Override
	public Partido registrar(Partido obj) {
		return repo.save(obj);
	}
	
	@Transactional
	@Override
	public Partido registrarTransaccional(PartidoResultadoDTO dto) {
		repo.save(dto.getPartido());
		reRepo.registrar(dto.getPartido().getIdPartido(), dto.getResultado().getLocal(), dto.getResultado().getVisitante());
		return dto.getPartido();		
	}

	@Override
	public Partido modificar(Partido obj) {
		return repo.save(obj);
	}

	@Override
	public List<Partido> listar() {
		return repo.findAll();
	}

	@Override
	public Partido leerPorId(Integer id) {
		Optional<Partido> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Partido();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}	

	@Override
	public List<Partido> buscarFecha(FiltroPartidoDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaPartido().plusDays(1);
		return repo.buscarFecha(filtro.getFechaPartido(), fechaSgte);
	}
	
	@Override
	public List<PartidoResumenDTO> listarResumen() {
		List<PartidoResumenDTO> partidos = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			PartidoResumenDTO pr = new PartidoResumenDTO();
			pr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			pr.setFecha(String.valueOf(x[1]));
			partidos.add(pr);
		});
		return partidos;
	}
	
	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}
	

}
