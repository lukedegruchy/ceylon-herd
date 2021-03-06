package util;

import java.util.List;

import com.github.rjeschke.txtmark.BlockEmitter;

class MarkdownBlockEmitter implements BlockEmitter {

    static final MarkdownBlockEmitter INSTANCE = new MarkdownBlockEmitter();

    @Override
    public void emitBlock(StringBuilder out, List<String> lines, String meta) {
        if (!lines.isEmpty()) {
            if (meta == null || meta.length() == 0) {
                // default to ceylon code
                meta = "ceylon";
            }
            out.append("<pre data-language='").append(meta).append("'>");
            for (String line : lines) {
                out.append(line).append('\n');
            }
            out.append("</pre>\n");
        }
    }

}