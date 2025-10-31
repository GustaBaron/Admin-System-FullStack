package com.Sneaker_Collection.service;


import com.Sneaker_Collection.entity.Tenis;
import com.Sneaker_Collection.repository.TenisRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TenisService {

    private final TenisRepository tenisRepository;

    public TenisService(TenisRepository tenisRepository) {
        this.tenisRepository = tenisRepository;
    }

    public List<Tenis> findAll() {
        return tenisRepository.findAll();
    }

    public void adicionarTenis(){
        var tenis = new Tenis();
        tenis.setMarca("Nike");
        tenis.setModelo("Air Jordan 1");
        tenis.setAno_lancamento("1985");
        tenis.setTenisUrl("https://www.nike.com.br/snkrs/air-jordan-1-low-se-058357.html?cor=51");
        tenisRepository.save(tenis);

        tenis = new Tenis();
        tenis.setMarca("Adidas");
        tenis.setModelo("Superstar");
        tenis.setAno_lancamento("1969");
        tenis.setTenisUrl("https://www.adidas.com.br/tenis-superstar/JK4968.html");
        tenisRepository.save(tenis);

        tenis = new Tenis();
        tenis.setMarca("Puma");
        tenis.setModelo("Suede Classic");
        tenis.setAno_lancamento("1968");
        tenis.setTenisUrl("https://br.puma.com/pd/tenis-suede-classic-xxi/385378.html?color=01");
        tenisRepository.save(tenis);

        tenis = new Tenis();
        tenis.setMarca("Converse");
        tenis.setModelo("Chuck Taylor All-Star");
        tenis.setAno_lancamento("1917");
        tenis.setTenisUrl("https://example.com/images/chuck_taylor.png");
        tenisRepository.save(tenis);

        tenis = new Tenis();
        tenis.setMarca("Vans");
        tenis.setModelo("Old Skool");
        tenis.setAno_lancamento("1977");
        tenis.setTenisUrl("https://example.com/images/vans_old_skool.png");
        tenisRepository.save(tenis);

        tenis = new Tenis();
        tenis.setMarca("Nike");
        tenis.setModelo("Air Force 1");
        tenis.setAno_lancamento("1982");
        tenis.setTenisUrl("https://example.com/images/air_force_1.png");
        tenisRepository.save(tenis);
        }


        public void deletarTudo(){
            tenisRepository.deleteAll();
        }

        /**
         * Consulta todos os países e escolhe um aleatoriamente
         * Caso não possuir países cadastrados, ele retorna um Optional.empty()
         * @return
         */
        public Optional<Tenis> obterUmTenisAleatoriamente() {
            var lista = findAll();
            if(lista.isEmpty()){ return Optional.empty();}
            return Optional.ofNullable(lista.get((int) (Math.random() * lista.size())));
        }
    }
