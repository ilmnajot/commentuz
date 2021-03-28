package uz.projavadev.commentuz.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.TagDto;
import uz.projavadev.commentuz.entity.Tag;
import uz.projavadev.commentuz.repository.TagRepository;
import uz.projavadev.commentuz.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Page<TagDto> findAll(Pageable pageable) {
        return tagRepository.findAll(pageable).map(TagDto::toDto);
    }

    @Override
    public Page<TagDto> search(String searchTerm, Pageable pageable) {
        return tagRepository.findByNameContains(searchTerm, pageable).map(TagDto::toDto);
    }

    @Override
    public TagDto add(TagDto form) {
        Tag tag = new Tag();
        tag.setName(form.getName());
        return TagDto.toDto(tagRepository.save(tag));
    }

    @Override
    public TagDto update(Long id, TagDto form) {
        Tag tag = tagRepository.getOne(id);
        tag.setName(form.getName());
        return TagDto.toDto(tagRepository.save(tag));
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}
